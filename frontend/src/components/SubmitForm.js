import React, { useState } from 'react'

const initialPerson = {
  name: '',
  nationality: '',
  gender: '',
  ethnicity: '',
  birthday: '',
}

const SubmitForm = ({submitForm}) => {
  const [person, setPerson] = useState(initialPerson);
  const { name, nationality, gender, ethnicity, birthday } = person;

  const onChange = (event) => {
    const { name, value } = event.target;
    setPerson(prevState => ({ ...prevState, [name]: value }))
  };

  const handleSubmit = (e) => {
    e.preventDefault()
    submitForm(person,() => setPerson(initialPerson));
  };

  return (
      <div style={styles.containers}>
        <form onSubmit={handleSubmit} style={styles.formStyle}>
          <label>FirstName</label>
          <input name={'name'} value={name} onChange={onChange}/>
          <label>Nationality</label>
          <input name={'nationality'} value={nationality} onChange={onChange}/>
          <label>Gender</label>
          <input name={'gender'} value={gender} onChange={onChange}/>
          <label>Ethnicity</label>
          <input name={'ethnicity'} value={ethnicity} onChange={onChange}/>
          <label>Birthday</label>
          <input name={'birthday'} value={birthday} onChange={onChange}/>
          <button>Tell me my fortune</button>
        </form>
      </div>
  )
}

const styles = {
  containers: {
    display: 'flex',
    justifyContent: 'center',
    alignSelf: 'center',
  },
  formStyle: {
    width: 250,
    display: 'flex',
    flexDirection: 'column',
  },
}
export default SubmitForm;
