import { Link } from "react-router-dom";
import '../../App.css';

const Navbar = () => {
    return(
        <nav className="navbar">
          <ul className="navbar-list">
            <li className="navbar-item"><Link className="navbar-link" to="/">Home</Link></li>
            <li className="navbar-item"><Link className="navbar-link" to="/signin">Sign In</Link></li>
            <li className="navbar-item"><Link className="navbar-link" to="/signup">Sign up</Link></li>
            <li className="navbar-item"><Link className="navbar-link" to="/options">Options</Link></li>
            <li className="navbar-item"><Link className="navbar-link" to="/customercare">Customer Care</Link></li>
          </ul>
        </nav>
    );
}

export default Navbar;
