package example;


import org.testng.annotations.Test;
import payload.NewUser_Payload;
import util.ConfigReader;
import util.TestUtil;

public class POST_NewUser extends TestUtil {

    @Test
    public void createNewUser() {

        createRequest().body(NewUser_Payload.newUserPayload());
        executeAPI("POST", ConfigReader.getProperty("postPathParameter"));
        responseSpecification(201);
       // getResponse();
    }

}

//    fetch('https://jsonplaceholder.typicode.com/posts', {
//        method: 'POST',
//                body: JSON.stringify({
//                title: 'foo',
//                body: 'bar',
//                userId: 1,
//  }),
//        headers: {
//            'Content-type': 'application/json; charset=UTF-8',
//        },
//    })
//        .then((response) => response.json())
//        .then((json) => console.log(json));