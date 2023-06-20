import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

export default function AddKunde() {

    let navigate = useNavigate()

    const [kunde,setKunde] = useState({
        firstname:"",
        lastname:"",
        adresse:"",
        telnummer:""
    });

    const{firstname,lastname,adresse,telnummer}=kunde;

    const onInputChange=(e)=>{
        setKunde({...kunde,[e.target.name]:e.target.value});
    };

    const onSubmit = async(e)=>{
        e.preventDefault();
        await axios.post("http://localhost:8080/kunde",kunde);
        navigate("/")
    }


    
  return (
    <div className="container">
        <div className="row">
            <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                <h2 className='text-center m-4'>Register Kunde</h2>

                
                <form onSubmit={(e)=>onSubmit(e)}>
                    <div className='mb-3'>
                        <label htmlFor="firstname" className="form-label">
                            First Name
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter your First Name"
                            name="firstname"
                            value={firstname}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="lastname" className="form-label">
                            Last Name
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter your Last Name"
                            name="lastname"
                            value={lastname}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="adresse" className="form-label">
                             adresse
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter your adresse"
                            name="adresse"
                            value={adresse}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <div className='mb-3'>
                        <label htmlFor="telnummer" className="form-label">
                        telnummer
                        </label>
                        <input
                            type={"text"}
                            className="form-control"
                            placeholder="Enter your telnummer"
                            name="telnummer"
                            value={telnummer}
                            onChange={(e)=>onInputChange(e)}
                        />
                    </div>
                    <button type="submit" className="btn btn-outline-primary">
                        Submit
                    </button>
                    <Link className="btn btn-outline-danger mx-2" to="/">
                        Cancel
                    </Link>
                </form>
            </div>
            

        </div>
    </div>
  )
}
