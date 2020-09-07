# alm02-atefs-fazliz-joakimo-victoro
## Fortune Teller
School project created with Spring boot, React. Used Jenkins for deployment. 

## Regarding Jenkins
The project is divided in two Jenkinfiles. 

Initially, the Jenkinsfile was both for building the spring boot, creating the React application using Node.js and Deploying the war file. 
Due to write permissions the build failed using npm install > npm run build. Instead, a static index file is used to provide the user with a form for getting fortunes.

The first Jenkinsfile(Jenkinsfile) contains the initial build, publishing reports and saving the war file.
The second one(JenkinsfileDeploy) contains the depoyment.
```typescript
stage ('Deploy') {
  steps {
    echo 'Deploying...'
    sh 'mvn spring-boot:run'
  }
}
```

**NOTE:** Once the application has been deployed, it's accessible via port: 8084 (http://localhost:8084/). Edited to not use the same port as Jenkins.

Team
Project created by Atef, Fazli, Victor and Joakim.

2020 Nackademin
