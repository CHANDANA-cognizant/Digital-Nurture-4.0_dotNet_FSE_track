// Register.js
import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    password: ''
  });

  const [errors, setErrors] = useState({});

  const validate = () => {
    let newErrors = {};

    if (formData.name.trim().length < 5) {
      newErrors.name = "Name should have at least 5 characters";
    }

    if (!formData.email.includes('@') || !formData.email.includes('.')) {
      newErrors.email = "Invalid email format";
    }

    if (formData.password.length < 8) {
      newErrors.password = "Password should have at least 8 characters";
    }

    setErrors(newErrors);

    // Returns true if no errors
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData({
      ...formData,
      [name]: value
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (validate()) {
      alert('Registration Successful!');
      setFormData({ name: '', email: '', password: '' });
      setErrors({});
    }
  };

  return (
    <div style={{ maxWidth: '400px', margin: '0 auto', fontFamily: 'Arial' }}>
      <h2>Mail Registration Form</h2>
      <form onSubmit={handleSubmit}>
        {/* Name Field */}
        <div style={{ marginBottom: '10px' }}>
          <label>Name:</label><br />
          <input
            type="text"
            name="name"
            value={formData.name}
            onChange={handleChange}
            style={{ width: '100%', padding: '8px' }}
          />
          {errors.name && <div style={{ color: 'red' }}>{errors.name}</div>}
        </div>

        {/* Email Field */}
        <div style={{ marginBottom: '10px' }}>
          <label>Email:</label><br />
          <input
            type="text"
            name="email"
            value={formData.email}
            onChange={handleChange}
            style={{ width: '100%', padding: '8px' }}
          />
          {errors.email && <div style={{ color: 'red' }}>{errors.email}</div>}
        </div>

        {/* Password Field */}
        <div style={{ marginBottom: '10px' }}>
          <label>Password:</label><br />
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            style={{ width: '100%', padding: '8px' }}
          />
          {errors.password && <div style={{ color: 'red' }}>{errors.password}</div>}
        </div>

        {/* Submit */}
        <button type="submit" style={{ padding: '10px 20px' }}>
          Register
        </button>
      </form>
    </div>
  );
}

export default Register;
