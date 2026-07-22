import  { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      user: null,
    };
  }

  async componentDidMount() {
    const response = await fetch("https://api.randomuser.me/");
    const data = await response.json();

    this.setState({
      user: data.results[0],
    });
  }

  render() {
    const { user } = this.state;

    if (!user) {
      return <h2>Loading...</h2>;
    }

    return (
      <div className="container">
        <h2>User Details</h2>

        <img
          src={user.picture.large}
          alt="User"
        />

        <h3>
          {user.name.title} {user.name.first}
        </h3>
      </div>
    );
  }
}

export default Getuser;
