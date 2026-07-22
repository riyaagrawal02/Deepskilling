import { useState } from "react";

function Register() {
  const [form, setForm] = useState({
    name: "",
    email: "",
    password: "",
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  const validate = () => {
    const err = {};

    if (form.name.length < 5) {
      err.name = "Name should contain at least 5 characters";
    }

    if (!(form.email.includes("@") && form.email.includes("."))) {
      err.email = "Enter a valid Email";
    }

    if (form.password.length < 8) {
      err.password = "Password should contain at least 8 characters";
    }

    return err;
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const validationErrors = validate();

    setErrors(validationErrors);

    if (Object.keys(validationErrors).length === 0) {
      alert("Registration Successful!");

      setForm({
        name: "",
        email: "",
        password: "",
      });
    }
  };

  return (
    <div className="container">

      <h2>Mail Registration</h2>

      <form onSubmit={handleSubmit}>

        <label>Name</label>

        <input
          type="text"
          name="name"
          value={form.name}
          onChange={handleChange}
        />

        {errors.name && (
          <p className="error">{errors.name}</p>
        )}

        <label>Email</label>

        <input
          type="email"
          name="email"
          value={form.email}
          onChange={handleChange}
        />

        {errors.email && (
          <p className="error">{errors.email}</p>
        )}

        <label>Password</label>

        <input
          type="password"
          name="password"
          value={form.password}
          onChange={handleChange}
        />

        {errors.password && (
          <p className="error">{errors.password}</p>
        )}

        <button type="submit">
          Register
        </button>

      </form>

    </div>
  );
}

export default Register;