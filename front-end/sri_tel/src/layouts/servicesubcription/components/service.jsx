import React from 'react';

const Service = ({ name, description, cost }) => {
  return (
    <div>
      <h3>{name}</h3>
      <p>{description} - {cost}</p>
      <button>subscribe</button>
    </div>
  );
};

export default Service;
