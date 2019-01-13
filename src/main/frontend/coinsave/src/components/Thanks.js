import React, {Component} from 'react'
import { Switch, Route } from 'react-router-dom'
import Background from '../../src/img/cover/cover-10.jpg';


class Thanks extends Component {

  render() {
    return (
      <div>
      <div className="search-banner has-bg">
          
          <div className="bg-cover" data-paroller="true" data-paroller-factor="0.5" data-paroller-factor-xs="0.01" style={{backgroundImage: `url(${Background})`}}></div>
          
          <div className="container">
            <h1>Thanks for your submission<br /><p></p></h1>
          </div>
          
        </div>

        <div className="content" style={{marginLeft: '0px'}}>
          
          <div className="container">
            
            <div className="card card-forum mb-3">
              <div className="card-header">
                Submission details
              </div>
              <div class="panel-body">
              <form action="/" method="POST">
								<fieldset>
									<legend class="m-b-15">Legend</legend>
									<div class="form-group row m-b-15">
										<label class="col-md-3 col-form-label">Address</label>
										<div class="col-md-6">
                                          <label class="col-md-3 col-form-label">ccccccccccccccccccc</label>
										</div>
									</div>
									<div class="form-group row m-b-15">
                    <label class="col-form-label col-md-3">Some notes to prove address</label>
                    <div class="col-md-6">
                      <label class="col-md-3 col-form-label">details</label>
                    </div>
                  </div>
                  <div class="form-group row m-b-15">
                  <label class="col-form-label col-md-3">Scam type</label>
									<div class="col-md-6">
                                    <label class="col-md-3 col-form-label">Fraud Address</label>
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

export default Thanks