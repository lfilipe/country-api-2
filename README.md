Java Spring Boot App is running at Google Cloud Run:
https://spring-native-app-kzas66i27q-uc.a.run.app/

OpenAPI definition - Swagger UI
https://spring-native-app-kzas66i27q-uc.a.run.app/swagger-ui/index.html
 
1. Clone the repo
   ```sh
   $ git clone https://github.com/lfilipe/country-api-2.git
   ```
2. Access dir
   ```sh
   $ cd country-api-2/
   ```
3. Maven clean
   ```sh
   $ mvn clean
   ```
4. Maven package
   ```sh
   $ mvn package
   ```
6. Build the Spring Boot App Image
   ```sh
   $ mvn spring-boot:build-image
   ```
7. Check docker images on Cloud Shell
   ```sh
   $ docker images
   ```
8. Tag:
   ```sh
   $ docker tag country-api:0.0.1-SNAPSHOT us-central1-docker.pkg.dev/{PROJECT_ID}/spring-native-repo/sn-image:first
   ```
9. Push:
   ```sh
   $ docker push us-central1-docker.pkg.dev/{PROJECT_ID}/spring-native-repo/sn-image:first
   ```
10. Finally, deploy the app in Cloud Run
   ```sh
   $ gcloud run deploy spring-native-app --image us-central1-docker.pkg.dev/{PROJECT_ID}/spring-native-repo/sn-image:first --platform managed --region us-central1 --allow-unauthenticated
   ```

11. Once deployed, the service endpoint is presented your terminal:
   ```sh
      Deploying container to Cloud Run service [spring-native-app] in project [country-api-408214] region [us-central1]
      OK Deploying new service... Done.                                                                                                                                                                                                         
      OK Creating Revision...                                                                                                                                                                                                                 
      OK Routing traffic...                                                                                                                                                                                                                   
      OK Setting IAM Policy...                                                                                                                                                                                                                
      Done.                                                                                                                                                                                                                                     
      Service [spring-native-app] revision [spring-native-app-00001-4gw] has been deployed and is serving 100 percent of traffic.
      Service URL: https://spring-native-app-kzas66i27q-uc.a.run.app
   ```


<!-- Source -->
## Source
* [Spring Native and Serverless with Spring Boot apps on Google Cloud!](https://medium.com/google-cloud/spring-boot-native-images-on-google-cloud-94adfd48bc94)https://medium.com/google-cloud/spring-boot-native-images-on-google-cloud-94adfd48bc94)
