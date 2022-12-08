package com.application.sobesTask.model;

import com.application.sobesTask.entity.User;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Graph {

    private double avg;
    private int min;
    private int max;

    private Map<Integer, List<Integer>> relations;
}
