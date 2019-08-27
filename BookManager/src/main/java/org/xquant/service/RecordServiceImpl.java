package org.xquant.service;

import org.springframework.stereotype.Service;
import org.xquant.dao.RecordMapper;
import org.xquant.pojo.Record;
import org.xquant.pojo.RecordResult;
import org.xquant.service.impl.RecordService;


import javax.annotation.Resource;
import java.util.List;

@Service("recordService")
public class RecordServiceImpl implements RecordService {
    @Resource
    RecordMapper recordMapper;

    public List<RecordResult> getAllRecords(){
        return recordMapper.getAllRecords();
    };

    public Record getRecordBySno(String Sno){
        return recordMapper.getRecordBySno(Sno);
    };

    public List<RecordResult> getRecordByBookName(String book_name){
        return recordMapper.getRecordByBookName(book_name);
    };

    public int updateState(int state,int book_id){
        return recordMapper.updateState(state,book_id);
    };

    public int addRecord(Record record){
        return recordMapper.addRecord(record);
    };

    public int deleteRecord(int id){
        return recordMapper.deleteRecord(id);
    };
}
