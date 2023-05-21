package patterns.practicies;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import patterns.practicies.model.Item;
import patterns.practicies.model.Order;
import patterns.practicies.service.ItemService;
import patterns.practicies.service.OrderService;
import patterns.practicies.service.SchedulerService;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SchedulerServiceTest {
    private SchedulerService schedulerService;
    @Mock
    private ItemService itemService;
    @Mock
    private OrderService orderService;

    @BeforeEach
    public void setUp() throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanRegistrationException {
        schedulerService = new SchedulerService(itemService, orderService);
    }

    @Test
    public void testMakeBackup() throws Exception {
        SchedulerService schedulerService = Mockito.spy(new SchedulerService(itemService, orderService));
        Field directoryField = SchedulerService.class.getDeclaredField("DIRECTORY");
        directoryField.setAccessible(true);
        directoryField.set(schedulerService, "src/backups/");

        File backupDirectory = new File("src/backups/");
        FileUtils.deleteDirectory(backupDirectory);
        backupDirectory.mkdirs();

        Item item = new Item("item1", String.valueOf(new Date()), 10);
        Order order = new Order();
        Mockito.when(itemService.findAll()).thenReturn(Collections.singletonList(item));
        Mockito.when(orderService.findAll()).thenReturn(Collections.singletonList(order));

        schedulerService.makeBackup();

        File[] backupFiles = backupDirectory.listFiles();
        assertEquals(2, backupFiles.length);
    }
}
