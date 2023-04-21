package com.example.task.controller;

import com.example.task.entity.Items;
import com.example.task.response.Response;
import com.example.task.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author by @Ahmed Adel
 */
@Slf4j
@RestController
@RequestMapping(path = {"api/v1"})
@Tag(name = "Items", description = "Project API's")
public class ItemsController {


    @Autowired
    ItemService itemService;

    @Operation(summary = "add space", description = "", tags = { "Items" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "Error in saving")
    })
    @RequestMapping(value = "/create-space", method = RequestMethod.POST)
    private ResponseEntity<Items> createSpace() {


        try {
            Items item = itemService.createSpace();
            return ResponseEntity.status(HttpStatus.OK).body(item);

        }
        catch (Exception e){

            log.error("error in create space: "+e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "add space under", description = "", tags = { "Items" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "Error in saving")
    })
    @RequestMapping(value = "/create-space-under", method = RequestMethod.POST)
    private ResponseEntity<Items> createSpaceUnder() {


        try {
            Items item = itemService.createSpaceUnder();
            return ResponseEntity.status(HttpStatus.OK).body(item);

        }
        catch (Exception e){

            log.error("error in create space: "+e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Operation(summary = "add space under", description = "", tags = { "Items" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "500", description = "Error in saving")
    })
    @RequestMapping(value = "/create-file", method = RequestMethod.POST)
    private ResponseEntity<Items> createFile() {


        try {
            Items item = itemService.createFile();
            return ResponseEntity.status(HttpStatus.OK).body(item);

        }
        catch (Exception e){

            log.error("error in create space: "+e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}