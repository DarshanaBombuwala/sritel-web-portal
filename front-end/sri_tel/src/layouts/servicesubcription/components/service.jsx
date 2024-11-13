import axios from "axios";
import React, { useState } from "react";
import "../../../App.css";
import { useAxios } from "../../../hooks/useAxiso";

const Service = ({ sub, id, name, description, cost }) => {
  const { api } = useAxios();

  const [subscribed, setSubscribed] = useState(false);

  const subscribe = async () => {
    await api
      .post(
        `/SERVICE-SUBSCRIPTION-SERVICE/api/subscription/${
          subscribed || sub ? "deactivate" : "activate"
        }/${id}`
      )
      .then((response) => {
        setSubscribed(true);
      })
      .catch((error) => {});
  };
  return (
    <div className="subscription-details-container">
      <h3 className="subscription-name">{name}</h3>
      <p className="subscription-description">
        {description} - {cost}
      </p>
      {subscribed && (
        <div>
          <p>
            <b>Subscibed to service</b>
          </p>
        </div>
      )}
      <button className="subscribe-button" onClick={subscribe}>
        {subscribed || sub ? "Unsubscribe" : "Subscribe"}
      </button>
    </div>
  );
};

export default Service;
