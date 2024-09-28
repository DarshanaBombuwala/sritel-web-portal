import React from 'react';
import '../../../App.css';

const Service = ({ name, description }) => {
  return (
    <div className="subscription-details-container">
      <h3 className="subscription-name">{name}</h3>
      <p className="subscription-description">{description}</p>
      <button className="subscribe-button">Subscribe</button>
    </div>
  );
};

export default Service;
