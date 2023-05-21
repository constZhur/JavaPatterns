package patterns.practicies.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import patterns.practicies.model.Item;
import patterns.practicies.model.Order;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Service
@Slf4j
@ManagedResource
public class SchedulerService {
    private final String DIRECTORY = "src/backups/";
    private final ItemService itemService;
    private final OrderService orderService;
    @Autowired
    public SchedulerService(ItemService itemService, OrderService orderService) throws NotCompliantMBeanException,
            InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    @ManagedOperation
    @Scheduled(cron = "*/30 * * * * *")
    public void makeBackup() throws IOException {
        log.info("Scheduled task started: deleting files");
        File backupDir = ResourceUtils.getFile(DIRECTORY);
        for (File file : backupDir.listFiles()) {
            if (file.isFile()) {
                file.delete();
                log.info("File {} deleted", file.getName());
            }
        }
        log.info("All files deleted\n" +
                "Writing updated data from items and orders tables");

        FileWriter writer = new FileWriter(DIRECTORY + "items.txt");
        for (Item item : itemService.findAll()) {
            writer.write(item.toString() + '\n');
        }
        writer.close();

        writer = new FileWriter(DIRECTORY + "orders.txt");
        for (Order order : orderService.findAll()) {
            writer.write(order.toString() + '\n');
        }
        writer.close();
        log.info("Finished writing\n" +
                "Scheduled task ended");
    }
}
