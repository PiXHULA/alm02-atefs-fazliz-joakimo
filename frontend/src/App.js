import React, { useContext } from 'react';
import './App.css';
import SubmitForm from "./components/SubmitForm";
import { Context } from "./context/PersonProvider";


const App = () => {
  const { state: { fortune, errMessage }, sendPerson } = useContext(Context);
  const errors = errMessage.map(message => <div key={message}>{message}</div>)

  return (

      <div className="App">

        <h1>Hello</h1>
        <SubmitForm submitForm={sendPerson}/>
        <p>{fortune.fortune}</p>

        {errMessage.length > 0
            ? <div>{errors}</div> : null}
        {/*<Persons/>*/}
      </div>)
};

export default App;
