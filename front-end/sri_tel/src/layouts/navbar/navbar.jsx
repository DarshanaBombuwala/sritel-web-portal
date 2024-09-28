import { Link } from "react-router-dom";

const Navbar = () => {
    return(
        <nav>
          <ul>
            <li><Link to="/">Home</Link></li>
            <li><Link to="/signin">Sign In</Link></li>
            <li><Link to="/signup">Sign up</Link></li>
            <li><Link to="/options">options</Link></li>
            <li><Link to="/customercare">customer care</Link></li>

          </ul>
        </nav>
    );
}

export default Navbar;

