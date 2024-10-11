import axios from 'axios';
import React from 'react';


const Service = ({ sub, key, name, description, cost }) => {

  
  const subscribe = async () => {
    await axios.post(`http://localhost:8081/SUBSCRPTION_SERVICE/api/subscription/${sub?'deactivate':'activate'}/${key}`)
      .then(response => {

      })
      .catch(error => {

      })
  }
  return (
    <div>
      <h3>{name}</h3>
      <p>{description} - {cost}</p>
      <button onClick={subscribe}>{sub?'Unsubscribe':'Subscribe'}</button>
    </div>
  );
};

export default Service;
