package ru.shadowd3m.spring.dao;

import org.springframework.stereotype.Repository;
import ru.shadowd3m.spring.entity.Record;
import ru.shadowd3m.spring.entity.RecordStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RecordDao {
    private final List<Record> records = new ArrayList<>(
            Arrays.asList(
                    new Record("Take a shower", RecordStatus.ACTIVE),
                    new Record("buy flowers", RecordStatus.DONE),
                    new Record("Go to the gym", RecordStatus.ACTIVE)
            )
    );

    public List<Record> findAllRecords(){
        return new ArrayList<>(records);
    }

    public void saveRecord(Record record){
        records.add(record);
    }

    public void updateRecordStatus(int id, RecordStatus newStatus){
        for (Record item : records) {
            if(item.getId() == id){
                item.setStatus(newStatus);
                break;
            }
        }
    }

    public void deleteRecord(int id){
        records.removeIf(record -> record.getId() == id);
    }
}
