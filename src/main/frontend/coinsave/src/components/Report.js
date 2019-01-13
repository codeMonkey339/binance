import React, {Component} from 'react'
import { Switch, Route, Redirect } from 'react-router-dom'
import Background from '../../src/img/cover/cover-10.jpg';
import { Link } from 'react-router-dom'


class Report extends Component {

  sendRequest = () => {
    /*
    fetch('https://localhost:8080/addr/submit', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        address: 'yourValue',
        scamType: 'yourOtherValue',
        info: ''
      })
    })
    */
   //return <Redirect to="/thanks"/>
  }

  render() {
    return (
      <div>
      <div className="search-banner has-bg">
          
          <div className="bg-cover" data-paroller="true" data-paroller-factor="0.5" data-paroller-factor-xs="0.01" style={{backgroundImage: `url(${Background})`}}></div>
          
          <div className="container">
            <h1>Submit bad address<br /><p>Submit to get awards</p></h1>
          </div>
          
        </div>

        <div className="content" style={{marginLeft: '0px'}}>
          
          <div className="container">
            
            <div className="card card-forum mb-3">
              <div className="card-header">
                Address details
              </div>
              <div class="panel-body">
              <form onSubmit={this.sendRequest}>
								<fieldset>
									<legend class="m-b-15">Legend</legend>
									<div class="form-group row m-b-15">
										<label class="col-md-3 col-form-label">Address</label>
										<div class="col-md-6">
											<input type="" class="form-control" placeholder="" />
										</div>
									</div>
									<div class="form-group row m-b-15">
                    <label class="col-form-label col-md-3">Some notes to prove address</label>
                    <div class="col-md-6">
                      <textarea class="form-control" rows="3"></textarea>
                    </div>
                  </div>
                  <div class="form-group row m-b-15">
                  <label class="col-form-label col-md-3">Scam type</label>
									<div class="col-md-6">
										<select class="form-control">
											<option>Money Laundry</option>
											<option>Fraud</option>
											<option>Fake Address</option>
										</select>
									</div>
                  </div>
									
									<div class="form-group row">
										<div class="col-md-7 offset-md-3">
                     <Link to="/thanks" class="btn btn-primary m-r-5">Submit</Link>
											</div>
									</div>
								</fieldset>
							</form>
              </div>
            </div>
          </div>
        </div>
					
				<div className="register-content">
      
				</div>	
			
  </div>
    );
  }
}

export default Report