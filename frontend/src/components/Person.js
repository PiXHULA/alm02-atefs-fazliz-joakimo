import React, { useContext, useEffect } from "react";
import { Context } from "../context/PersonProvider";

const Persons = () => {
  const { fetchPersons, state: { persons } } = useContext(Context);

  useEffect(() => { //Similar to component did mount
    fetchPersons();
  }, []) //If there's anything that changes, useEffect will revoke itself

  return persons.map((person, index) => {
    return (
        <div key={index}>
          <h1>{person.name}</h1>
          <p>{person.id}</p>
          <p>{person.nationality}</p>
          <p>{person.gender}</p>
          <p>{person.ethnicity}</p>
          <p>{person.birthday}</p>
        </div>
    )
  })
}

export default Persons;
