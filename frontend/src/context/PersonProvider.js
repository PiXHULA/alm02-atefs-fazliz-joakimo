import createDataContext from "./personContext";
import personsApi from "../api/personsApi";
import { ERROR_MESSAGE, FORTUNE, GET_CUSTOMERS } from "./types";

const reducer = (state, action) => {
  switch (action.type) {
    case GET_CUSTOMERS:
      return { ...state, persons: action.payload }
    case FORTUNE:
      return { ...state, fortune: action.payload }
    case ERROR_MESSAGE:
      return { ...state, errMessage: action.payload }
    default:
      return state;
  }
}

const fetchPersons = dispatch => () => {
  personsApi.get('/person/all').then(response => {
    dispatch({ type: GET_CUSTOMERS, payload: response.data })
  });
}

const sendPerson = dispatch => async (person) => {
  // try {
  //   const response = await personsApi.post('/person', person)
  //   dispatch({type: FORTUNE, payload: response.data})
  // } catch (e) {
  //   dispatch({type: ERROR_MESSAGE, payload: "Error message"})
  // }
  personsApi.post('/person',person).then(response => {
    dispatch({ type: FORTUNE, payload: response.data })
  }).catch(e =>
    console.log(e))
}

const initialState = {
  persons: [],
  errMessage: '',
  fortune: ''
}

export const { Provider, Context } = createDataContext(reducer,
    { fetchPersons, sendPerson }, // PASS THE DEFINED ACTIONS INTO THIS OBJECT
    initialState)  // INITIAL STATE -> {} or [] or ''
