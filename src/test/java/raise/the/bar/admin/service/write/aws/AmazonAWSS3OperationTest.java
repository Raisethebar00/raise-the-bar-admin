package raise.the.bar.admin.service.write.aws;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import raise.the.bar.admin.write.aws.AmazonAWSS3Operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Sujeet on 3/8/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmazonAWSS3OperationTest {

    @Autowired
    private AmazonAWSS3Operation amazonAWSS3Operation;

    private File pic;


    private Path path;

    @Before
    public void setUp(){

        path = Paths.get("/Users/Manish/Pictures/003.JPG");
    }

    @Test
    public void uploadFilesToS3_OK() throws IOException {

        amazonAWSS3Operation.uploadFilesToS3(new MockMultipartFile("new Name", Files.readAllBytes(path)),"testbucket");
    }

}
