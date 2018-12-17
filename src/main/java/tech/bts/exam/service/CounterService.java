package tech.bts.exam.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CounterService {


    private long counterId;
    private Map<Long, Integer> counterMap;
    private int value;
    private int counter;


    public CounterService() {
        counterMap = new HashMap<>();
        counterId = 0;
        value = 0;
        counter = 0;
    }


    public void addCounter(){
        counterMap.put(counterId, counter);
        counterId++;
        counter++;
    }

    public void increaseCounter(){
        value++;
    }

    public int getValue(){
        return value;
    }

    public int getCounter() {
        return counter;
    }

    public List<Integer> getAllCounters(){
        return new ArrayList<>(counterMap.values());
    }

}
