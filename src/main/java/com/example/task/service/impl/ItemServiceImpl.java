package com.example.task.service.impl;

import com.example.task.entity.Items;
import com.example.task.entity.PermissionGroup;
import com.example.task.entity.Permissions;
import com.example.task.repository.ItemsRepository;
import com.example.task.repository.PermissionGroupRepository;
import com.example.task.repository.PermissionsRepository;
import com.example.task.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemsRepository itemsRepository;

    @Autowired
    PermissionGroupRepository permissionGroupRepository;

    @Autowired
    PermissionsRepository permissionsRepository;

    @Override
    public Items createSpace() {

        Items item = itemsRepository.findByName("stc-assessments");

        if(item == null){
            item = new Items();

            item.setName("stc-assessments");
            item.setType("Space");

            PermissionGroup permissionGroup = permissionGroupRepository.findByGroup_name("admin");

            if(permissionGroup == null){
                permissionGroup = new PermissionGroup();
                permissionGroup.setGroup_name("admin");

                Permissions permissionsEdit = permissionsRepository.findByPermission_level("edit","admin");
                if(permissionsEdit == null){

                    permissionsEdit = new Permissions();
                    permissionsEdit.setPermission_level("edit");
                    permissionsEdit.setUser_email("admin");
                    permissionsRepository.save(permissionsEdit);
                }

                Permissions permissionsView = permissionsRepository.findByPermission_level("view","admin");
                if(permissionsView == null){

                    permissionsView = new Permissions();
                    permissionsView.setPermission_level("view");
                    permissionsView.setUser_email("admin");
                    permissionsRepository.save(permissionsView);
                }

                List<Permissions> permissionsList = new ArrayList<>();
                permissionsList.add(permissionsEdit);
                permissionsList.add(permissionsView);

                permissionGroup.setPermissions(permissionsList);

                permissionGroupRepository.save(permissionGroup);

                permissionsView.setPermissionGroup(permissionGroup);
                permissionsRepository.save(permissionsView);

                permissionsEdit.setPermissionGroup(permissionGroup);
                permissionsRepository.save(permissionsEdit);

            }

            item.setItemPermissionGroup(permissionGroup);

            itemsRepository.save(item);
            createPartation("stc-assessments");

        }

        return  item;
    }

    @Override
    public Items createSpaceUnder() {

        Items item = itemsRepository.findByName("stc-assessments/backend");

        if(item == null){
            item = new Items();

            item.setName("stc-assessments/backend");
            item.setType("Folder");

            PermissionGroup permissionGroup = permissionGroupRepository.findByGroup_name("user");

            if(permissionGroup == null){
                permissionGroup = new PermissionGroup();
                permissionGroup.setGroup_name("user");

                Permissions permissionsEdit = permissionsRepository.findByPermission_level("edit","user");
                if(permissionsEdit == null){

                    permissionsEdit = new Permissions();
                    permissionsEdit.setPermission_level("edit");
                    permissionsEdit.setUser_email("user");
                    permissionsRepository.save(permissionsEdit);
                }

                List<Permissions> permissionsList = new ArrayList<>();
                permissionsList.add(permissionsEdit);

                permissionGroup.setPermissions(permissionsList);

                permissionGroupRepository.save(permissionGroup);


                permissionsEdit.setPermissionGroup(permissionGroup);
                permissionsRepository.save(permissionsEdit);

            }

            item.setItemPermissionGroup(permissionGroup);

            itemsRepository.save(item);
            createPartation("stc-assessments/backend");

        }

        return  item;
    }

    @Override
    public Items createFile() throws IOException {
        Items item = itemsRepository.findByName("stc-assessments/backend/assessment.pdf");

        if(item == null){
            item = new Items();

            item.setName("stc-assessments/backend/assessment.pdf");
            item.setType("File");

            PermissionGroup permissionGroup = permissionGroupRepository.findByGroup_name("user");

            if(permissionGroup == null){
                permissionGroup = new PermissionGroup();
                permissionGroup.setGroup_name("user");

                Permissions permissionsEdit = permissionsRepository.findByPermission_level("edit","user");
                if(permissionsEdit == null){

                    permissionsEdit = new Permissions();
                    permissionsEdit.setPermission_level("edit");
                    permissionsEdit.setUser_email("user");
                    permissionsRepository.save(permissionsEdit);
                }

                List<Permissions> permissionsList = new ArrayList<>();
                permissionsList.add(permissionsEdit);

                permissionGroup.setPermissions(permissionsList);

                permissionGroupRepository.save(permissionGroup);


                permissionsEdit.setPermissionGroup(permissionGroup);
                permissionsRepository.save(permissionsEdit);

            }

            item.setItemPermissionGroup(permissionGroup);


            itemsRepository.save(item);
            createPartationFile("stc-assessments\\backend\\assessment.pdf");

        }

        return  item;
    }

    public void createPartation(String name){

        String folderName = "D:\\"+name;
        File folder = new File( folderName );
        folder.mkdirs();
    }

    public void createPartationFile(String name) throws IOException {

        PDDocument pdfdoc= new PDDocument();
        pdfdoc.addPage(new PDPage());
        pdfdoc.save("D:\\"+name);
        pdfdoc.close();
    }

}
