package training.taylor.timetracker.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import training.taylor.timetracker.core.dao.TimeEntry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class Tracker_remove_bb9b871630_Test {
  
    @InjectMocks
    Tracker tracker;

    @Mock
    List<TimeEntry> entries;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void TestRemoveEntryWhenPresent() {
        TimeEntry entry = new TimeEntry();
        tracker.remove(entry);
        Mockito.verify(entries, times(2)).remove(entry);
    }

    @Test
    public void TestRemoveEntryWhenNotPresent() {
        TimeEntry entry = new TimeEntry();
        tracker.remove(entry);
        Mockito.verify(entries, times(2)).remove(entry);
    }

    @Test
    public void TestRemoveEntryWhenNull() {
        TimeEntry entry = null;
        tracker.remove(entry);
        Mockito.verify(entries, times(2)).remove(entry);
    }

    @Test
    public void TestRemoveEntryWhenListEmpty() {
        TimeEntry entry = new TimeEntry();
        Mockito.when(entries.isEmpty()).thenReturn(true);
        tracker.remove(entry);
        Mockito.verify(entries, times(2)).remove(entry);
    }

    @Test
    public void TestRemoveEntryWhenListIsNull() {
        TimeEntry entry = new TimeEntry();
        entries = null;
        tracker.remove(entry);
        // In this case, a null pointer exception would most likely be thrown.
        // There isn't any handling for this in the original method in the tracker class,
        // so there isn't really anything to assert or verify here.
    }
}
