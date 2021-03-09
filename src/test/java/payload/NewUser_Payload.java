package payload;

import pojo.NewUserPojo;

public class NewUser_Payload {
    public static NewUserPojo newUserPayload(){
        NewUserPojo user=new NewUserPojo();
        user.setUserId(11);
        user.setId(101);
        user.setTitle("Language");
        user.setBody("I do not have any idea about this language");
        return user;

    }
}


