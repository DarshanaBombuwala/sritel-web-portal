import React from 'react';
import { Link } from 'react-router-dom';

const OptionPage = () => {
  return (
    <div>
      <h2>Options Page</h2>
      <div>
        <h3>Choose an Option:</h3>
        <ul>
          <li>
            <Link to="/services">
              <button>Services</button>
            </Link>
          </li>
          <li>
            <Link to="/bills">
              <button>Bills</button>
            </Link>
          </li>
          <li>
            <Link to="/payments">
              <button>Payments</button>
            </Link>
          </li>
        </ul>
      </div>
    </div>
  );
};

export default OptionPage;
