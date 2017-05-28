package raise.the.bar.admin.write.aws;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static raise.the.bar.admin.helper.RTBConstant.CONTENT_TYPE_IMAGE_JPEG;

/**
 * Created by Sujeet on 3/8/17.
 */

@Service
public class AmazonAWSS3Operation {


    public String uploadFilesToS3(MultipartFile file, String bucketName) throws IOException {

        AmazonS3 amazonS3Client = new AmazonS3Client(new ProfileCredentialsProvider());
        InputStream inputStream = file.getInputStream();
        ObjectMetadata objectMetadata = new ObjectMetadata();

        objectMetadata.setContentType(CONTENT_TYPE_IMAGE_JPEG);
        String pictureName = UUID.randomUUID().toString().toLowerCase();

        amazonS3Client.putObject(new PutObjectRequest(bucketName,pictureName, inputStream,new ObjectMetadata())
                .withCannedAcl(CannedAccessControlList.PublicRead).withMetadata(objectMetadata));

        return amazonS3Client.getObject(bucketName,pictureName).getObjectContent()
                            .getHttpRequest().getURI().toString();
    }

    public void createNewBucket(String bucketName){

        AmazonS3 amazonS3Client = new AmazonS3Client(new ProfileCredentialsProvider());
        amazonS3Client.createBucket(bucketName);
    }
}
