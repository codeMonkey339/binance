import React, { Component } from 'react'
import { Switch, Route } from 'react-router-dom'
import Background from '../../src/img/cover/cover-10.jpg';



class Query extends Component {

  constructor(props) {
    super(props)
    this.state = {score: 0, info: 'details', isMoneyLaundry: 'No'}
  }

  fetchData = () => {
      fetch("http://localhost:8080//addr/query", {
        method: "GET",
        dataType: "JSON",
        headers: {
          "Content-Type": "application/json; charset=utf-8",
        }
      })
      .then((resp) => {
        return resp.json()
      }) 
      .then((data) => {
        this.setState({ score: data.suggestion, info: data.info })                    
      })
      .catch((error) => {
        console.log(error, "catch the hoop")
      })
    }

  render() {
    return (
      <div>
    <div className="search-banner has-bg">
          
          <div className="bg-cover" data-paroller="true" data-paroller-factor="0.5" data-paroller-factor-xs="0.01" style={{backgroundImage: `url(${Background})`}}></div>
          
          <div className="container">
            <h1>Query to get what you need</h1>
            <div className="input-group m-b-20">
              <input type="text" className="form-control form-control-lg" placeholder="Input wallet address" />
              <span className="input-group-append">
              <button type="submit" onClick={this.fetchData} className="btn btn-lg"><i className="fa fa-search"></i></button>
              </span>
            </div>
            <h5 className="f-s-14 m-b-10">Query by Categories</h5>
            <select class="form-control col-md-5">
              <option>Check address</option>
              <option>Check money laundary</option>
            </select>
          </div>
          
        </div>

    <div className="content" style={{marginLeft: '0px'}}>
          
    <div className="container">
      
      <div className="card card-forum mb-3">
        
        <div className="card-header">
          Result
        </div>
        
        <ul className="forum-list">
          <li>
            
            <div className="media">
              <img src={require('../../src/img/icon/icon-gold-note.png')} />
            </div>
            
            <div className="info-container">
              <div className="info">
                <h4 className="title">Score</h4>
                <p className="desc">
                higher score, higher danger
                </p>
              </div>
              <div className="total-count">
                <span className="total-post">{this.state.score}</span> <span className="divider">/</span> <span className="total-comment">100</span>
              </div>
              <div className="latest-post">
                <h4 className="title">For your security, please dont transfer to address whose score higher than 50</h4>
                <p className="time"> <a href="category_list.html" className="user"></a></p>
              </div>
            </div>

            <div className="info-container">
              <div className="info">
                <h4 className="title">Scam type</h4>
                
              </div>
              <div className="total-count">
                <span className="total-post">fraud address</span> <span className="divider"></span> <span className="total-comment"></span>
              </div>
              <div className="latest-post">
                <h4 className="title"><a href="category_list.html"></a></h4>
                <p className="time"> <a href="category_list.html" className="user">report it also</a></p>
              </div>
            </div>

            <div className="info-container">
              <div className="info">
                <h4 className="title">More information</h4>
                
              </div>
              <div className="total-count">
                <span className="total-post">{this.state.info}</span> <span className="divider"></span> <span className="total-comment"></span>
              </div>
              <div className="latest-post">
                
              </div>
            </div>
            
          </li>
        </ul>
        
      </div>
      
      <div className="card card-forum mb-3">
        
        <div className="card-header">
          Result
        </div>
        
        <ul className="forum-list">
          <li>
            
            <div className="media">
              <img src={require('../../src/img/icon/icon-gold-note.png')} />
            </div>
            
            <div className="info-container">
              <div className="info">
                <h4 className="title">Money laundary</h4>
                
              </div>
              <div className="total-count">
                <span className="total-post">{this.state.isMoneyLaundry}</span> <span className="divider"></span> <span className="total-comment"></span>
              </div>
              <div className="latest-post">
                <h4 className="title">For your security, please dont transfer to address who is a money laundry address</h4>
                <p className="time"> <a href="category_list.html" className="user"></a></p>
              </div>
            </div>

            <div className="info-container">
              <div className="info">
                
                
              </div>
              
            </div>
            
          </li>
        </ul>
        
      </div>
      
      
    </div>
    
  </div>
  
  
  </div>
    );
  }
}



export default Query