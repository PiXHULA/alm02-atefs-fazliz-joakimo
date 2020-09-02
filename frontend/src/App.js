import React, {useState,useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import axios from "axios";


const Persons = () => {
    const [persons, setPersons] = useState([]);
  const fetchPersons = () => {
    axios.get("http://localhost:8080/person/all").then(response => {
      console.log(response);
      setPersons(response.data);
    });
  }

  useEffect(()=> { //Similar to component did mount
    fetchPersons();
  }, []) //If there's anything that changes, useEffect will revoke itself

  return persons.map((person, index) => {
      return (
          <div key={index}>
          <h1>{person.name}</h1>
          <p>{person.id}</p>
      </div>
      )
  })
}

function App() {
  return (
      <div className="App">
        <h1>Hello</h1>
        <Persons/>
      </div>
  );
}

export default App;
