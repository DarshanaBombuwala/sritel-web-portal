import React from 'react';
import { Link } from 'react-router-dom';
import '../../App.css';

const OptionPage = () => {
  return (
    <div className="options-page">
      <h2 className="options-title">Options Page</h2>
      <div className="options-container">
        <h3 className="options-subtitle">Choose an Option:</h3>
        <ul className="options-list">
          <li className="options-list-item">
            <Link to="/services">
              <button className="options-button">Services</button>
            </Link>
          </li>
          <li className="options-list-item">
            <Link to="/bills">
              <button className="options-button">Bills</button>
            </Link>
          </li>
          <li className="options-list-item">
            <Link to="/payments">
              <button className="options-button">Payments</button>
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default OptionPage;
