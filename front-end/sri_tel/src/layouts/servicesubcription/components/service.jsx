import React from 'react';

const Service = ({ name, description }) => {
  return (
    <div>
      <h3>{name}</h3>
      <p>{description}</p>
      <button>subscribe</button>
    </div>
  );
};

export default Service;
