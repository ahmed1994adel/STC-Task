package com.example.task.service;

import com.example.task.entity.Items;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ItemService {

    Items createSpace();
    Items createSpaceUnder();
    Items createFile() throws IOException;

}
