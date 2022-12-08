package com.application.sobesTask.service;

import com.application.sobesTask.dao.UserDao;
import com.application.sobesTask.event.AddEvent;
import com.application.sobesTask.model.Graph;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDao userDao;

    public void save(AddEvent event) {
        var userList = event.getUser();
        userDao.saveUser(userList);
    }

    //Возможно в задаче подразумевается создание структуры с 2х мерным массивом ребер,
    // но кокретный вид хранения в графе не подсказан.
    // Поэтому в моем решении каждый узел сам хранит связи с другими узлами

    public Graph showGraph() {
        var users = userDao.getUsers();
        var graph = new Graph();
        var maxList = new ArrayList<Integer>();
        var minList = new ArrayList<Integer>();
        var sum = new ArrayList<Integer>();

        graph.setRelations(new HashMap<>());

        users.forEach(user -> {
            graph.getRelations().put(user.getIndex(), user.getRelation());
            minList.add(Collections.min(user.getRelation()));
            maxList.add(Collections.max(user.getRelation()));

            sum.add(user.getRelation().stream().reduce(0, Integer::sum));
        });

        var avg = sum.stream().reduce(0, Integer::sum) / users.size();

        graph.setMax(Collections.max(maxList));
        graph.setMin(Collections.min(maxList));
        graph.setAvg(avg);

        return graph;
    }
}
