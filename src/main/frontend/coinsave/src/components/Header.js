import React from 'react'
import { Link } from 'react-router-dom'


const Header = () => (
    <div>
        <div id="header" className="header navbar navbar-default navbar-fixed-top">
          
          <div className="container">
            
            <div className="navbar-header">
              <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#header-navbar">
                <span className="icon-bar"></span>
                <span className="icon-bar"></span>
                <span className="icon-bar"></span>
              </button>
              <a href="index.html" className="navbar-brand">
                <span className="navbar-logo"></span>
                <span className="brand-text">
                  CoinSave
                </span>
              </a>
            </div>
            
            <div className="collapse navbar-collapse" id="header-navbar">
              <ul className="nav navbar-nav navbar-right">
                <li><Link to='/query'>Home</Link></li>
                <li><Link to='/query'>Query</Link></li>
                <li><Link to='/report'>Report</Link></li>
                <li><Link to='/'>Create Account</Link></li>
                <li><Link to='/'>Sign In</Link></li>
              </ul>
            </div>
           
          </div>
          
        </div>
       

    </div>
)
export default Header