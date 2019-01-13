package com.safu.safecoin.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

/**
 * a simple mock
 */
@Service
public class SubmissionNumService {
    private List<Integer> range = null;
    public int getNumByDate(Date date){
        int reportNum = new Random().nextInt(50) + 1;
        if (Objects.nonNull(range)){
            range.set(reportNum, range.get(range.size()));
        }
        return reportNum;
    }

    public List<Integer> getNumsByRange(Date date, int duration){
        if (Objects.isNull(range)){
            Random rand = new Random();
            IntStream.range(0, 30)
                    .forEach(i -> range.add(rand.nextInt(50) + 1));
        }
        return range;
    }
}
