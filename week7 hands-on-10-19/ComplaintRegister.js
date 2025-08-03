// ComplaintRegister.js
import React, { useState } from 'react';

function ComplaintRegister() {
  const [employeeName, setEmployeeName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault(); // prevent page reload

    if (!employeeName || !complaint) {
      alert("Please fill out all fields.");
      return;
    }

    const referenceNumber = 'REF' + Math.floor(1000 + Math.random() * 9000);
    alert(`Complaint submitted successfully!\nReference No: ${referenceNumber}`);

    // Optionally clear the form
    setEmployeeName('');
    setComplaint('');
  };

  return (
    <div style={{ maxWidth: '500px', margin: '0 auto', fontFamily: 'Arial' }}>
      <h2>Raise a Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label>Employee Name:</label><br />
          <input
            type="text"
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            required
            style={{ width: '100%', padding: '8px' }}
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label>Complaint:</label><br />
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            rows="5"
            required
            style={{ width: '100%', padding: '8px' }}
          />
        </div>
        <button type="submit" style={{ padding: '10px 20px' }}>
          Submit Complaint
        </button>
      </form>
    </div>
  );
}

export default ComplaintRegister;
