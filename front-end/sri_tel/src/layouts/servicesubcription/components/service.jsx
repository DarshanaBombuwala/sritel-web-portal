import axios from 'axios';
import React, { useState } from 'react';
import '../../../App.css';

const Service = ({ sub, key, name, description, cost }) => {

  const [subscribed, setSubscribed ] = useState(false);
  
  const subscribe = async () => {
    await axios.post(`http://localhost:8081/SUBSCRPTION_SERVICE/api/subscription/${sub?'deactivate':'activate'}/${key}`)
      .then(response => {
        setSubscribed(true);
      })
      .catch(error => {

      })
  }
  return (
    <div className="subscription-details-container">
      <h3 className="subscription-name">{name}</h3>
      <p  className="subscription-description">{description} - {cost}</p>
      {subscribed && <div><p><b>Subscibed to service</b></p></div>}
      <button  className="subscribe-button" onClick={subscribe}>{sub?'Unsubscribe':'Subscribe'}</button>
      
    </div>
  );
};

export default Service;
