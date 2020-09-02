import React, { useContext } from 'react';
import './App.css';
import SubmitForm from "./components/SubmitForm";
import { Context } from "./context/PersonProvider";

const App = () => {
  const { state, sendPerson } = useContext(Context);

  return (
      <div className="App">
        <h1>Hello</h1>
        <SubmitForm submitForm={sendPerson}/>
        <p>{state.fortune.fortune}</p>
        {/*<Persons/>*/}
      </div>)
};

export default App;
