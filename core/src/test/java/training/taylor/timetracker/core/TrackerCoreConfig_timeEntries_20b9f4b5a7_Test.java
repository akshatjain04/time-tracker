package training.taylor.timetracker.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import training.taylor.timetracker.core.dao.TimeEntry;
import java.util.List;
import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrackerCoreConfig_timeEntries_20b9f4b5a7_Test {
  
    TrackerCoreConfig trackerCoreConfig = new TrackerCoreConfig();

    @Test
    public void testTimeEntries_returnsEmptyList() {
      List<TimeEntry> timeEntries = trackerCoreConfig.timeEntries();
      assertNotNull(timeEntries);
      assertEquals(0, timeEntries.size());
    }

    @Test
    public void testTimeEntries_populatedList() {
      List<TimeEntry> timeEntries = trackerCoreConfig.timeEntries();
      
      TimeEntry timeEntry1 = new TimeEntry();
      TimeEntry timeEntry2 = new TimeEntry();

      timeEntries.add(timeEntry1);
      timeEntries.add(timeEntry2);

      assertEquals(2, timeEntries.size());
      assertTrue(timeEntries.contains(timeEntry1));
      assertTrue(timeEntries.contains(timeEntry2));
    }

    @Test
    public void testTimeEntries_distinctMemoryAllocation() {
      List<TimeEntry> timeEntries1 = trackerCoreConfig.timeEntries();
      List<TimeEntry> timeEntries2 = trackerCoreConfig.timeEntries();
      
      assertNotSame(timeEntries1, timeEntries2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testTimeEntries_threadSafety() throws InterruptedException {
      List<TimeEntry> timeEntries = trackerCoreConfig.timeEntries();

      Thread thread1 = new Thread(() -> timeEntries.add(new TimeEntry()));
      Thread thread2 = new Thread(() -> timeEntries.remove(0));

      thread1.start();
      thread2.start();

      thread1.join();
      thread2.join();
    }

    @Test
    public void testTimeEntries_nullHandling() {
        List<TimeEntry> timeEntries = trackerCoreConfig.timeEntries();
        
        timeEntries.add(null);
        
        assertEquals(1, timeEntries.size());
    }

    @Test
    public void testTimeEntries_objectRemoval() {
        List<TimeEntry> timeEntries = trackerCoreConfig.timeEntries();
        
        TimeEntry timeEntry1 = new TimeEntry();
        TimeEntry timeEntry2 = new TimeEntry();

        timeEntries.add(timeEntry1);
        timeEntries.add(timeEntry2);
        
        timeEntries.remove(timeEntry1);
        
        assertEquals(1, timeEntries.size());
        assertFalse(timeEntries.contains(timeEntry1));
        assertTrue(timeEntries.contains(timeEntry2));
    }
}
