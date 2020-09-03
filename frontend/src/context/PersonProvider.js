import createDataContext from "./personContext";
import personsApi from "../api/personsApi";
import { ERROR_MESSAGE, FORTUNE, GET_CUSTOMERS, LOADING } from "./types";

const reducer = (state, action) => {
  switch (action.type) {
    case GET_CUSTOMERS:
      return { ...state, persons: action.payload }
    case FORTUNE:
      return { ...state, fortune: action.payload, errMessage: []}
    case ERROR_MESSAGE:
      return { ...state, fortune: '', errMessage: action.payload}
    default:
      return state;
  }
}

const fetchPersons = dispatch => async () => {
  try {
    const response = await personsApi.get('/person/all')
    dispatch({ type: GET_CUSTOMERS, payload: response.data })
  } catch (e) {
    console.log('Error')
  }
}

const sendPerson = dispatch => async (person,clearState) => {
  try {
    const response = await personsApi.post('/person', person);
    dispatch({ type: FORTUNE, payload: response.data })
    clearState()
  } catch ({ response }) {
    if (response.status === 400) {
      dispatch({ type: ERROR_MESSAGE, payload: response.data.errors })
    }
  }
}

const initialState = {
  persons: [],
  errMessage: [],
  fortune: ''
}

export const { Provider, Context } = createDataContext(reducer,
    { fetchPersons, sendPerson }, // PASS THE DEFINED ACTIONS INTO THIS OBJECT
    initialState)  // INITIAL STATE -> {} or [] or ''
