# Spring Boot and Cassandra via Docker

<img src="screenshots\cassandra_springboot.PNG" alt="Main Information" width="800" height="300">

### 📖 Information

<ul style="list-style-type:disc">
  <li><b>Apache Cassandra</b> is a <b>columnar</b> NoSQL Database and it reads and writes columns of data rather than the rows</li>
  <li>With <b>Apache Cassandra</b> , heavy-load applications sustains scalability and availability without compromising performance</li>
  <li>Here are the explation of this project
      <ul>
        <li>It just uses Spring Data Cassandra to make <b>CRUD</b> operations with <b>Apache Cassandra</b> which runs on <b>Docker Container</b></li>
      </ul>
  </li>
</ul>

### 🔨 Run the App

<b>1 )</b> Install <b>Docker Desktop</b>. Here is the installation <b>link</b> : https://docs.docker.com/docker-for-windows/install/

<b>2 )</b> Open Terminal under resources folder to run <b>Cassandra</b> on Docker Container
```
    docker-compose up -d
```

<b>2 )</b> Show <b>container</b> which runs on <b>Docker</b>
```
    docker ps
```

<b>3 )</b> To <b>save</b> person object, use a <b>POST</b> requested url with the request body
```
    http://localhost:8080/api/persons/save

    {
        "username": "Person2",
        "name": "Person2 Name",
        "surname": "Person2 Surname",
        "email": "person2@p.com",
        "birthDate": "1987-03-14",
        "password": "person2",
        "active": true
    }

```

<b>4 )</b> To show all person list , use a <b>GET</b> requested url
```
    http://localhost:8080/api/persons
```

<b>5 )</b> To get any specific person , use a <b>GET</b> requested url
```
    http://localhost:8080/api/persons/{person_id}
```

<b>6 )</b> To <b>update</b> any specific person , use a <b>PUT</b> requested url with the request body
```
    http://localhost:8080/api/persons/{person_id}

    {
        "username": "Person 1 New Username",
        "name": "Person1 New Name",
        "surname": "Person1 NewSurname",
        "email": "person1new@p.com",
        "birthDate": "1988-03-14",
        "password": "person1new",
        "active": true
    }
```

<b>7 )</b>To delete any specific person , use a <b>DELETE</b> requested url
```
    http://localhost:8080/api/persons/{person_id}
```

### Screenshots

<details>
<summary>Click here to show the screenshots of project</summary>
    <p> Figure 1 </p>
    <img src ="screenshots\cassandra1.PNG">
    <p> Figure 2 </p>
    <img src ="screenshots\cassandra2.PNG">
    <p> Figure 3 </p>
    <img src ="screenshots\cassandra3.PNG">
    <p> Figure 4 </p>
    <img src ="screenshots\cassandra4.PNG">
    <p> Figure 5 </p>
    <img src ="screenshots\cassandra5.PNG">
    <p> Figure 6 </p>
    <img src ="screenshots\cassandra6.PNG">
    <p> Figure 7 </p>
    <img src ="screenshots\cassandra7.PNG">
    <p> Figure 8 </p>
    <img src ="screenshots\cassandra8.PNG">
    <p> Figure 9 </p>
    <img src ="screenshots\cassandra9.PNG">
</details>