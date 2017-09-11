package com.jia.users.domain;

import org.springframework.data.annotation.Id;

public class UserGroup {

    @Id
    private String id;
    private String groupName;

}
