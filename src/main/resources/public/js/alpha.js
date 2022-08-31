class Alpha extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      function: "intraday",
      symbol: "",
      jsonRes: {},
      interval: "",
    };

    this.inputChange = this.inputChange.bind(this);
    this.optionSelecter = this.optionSelecter.bind(this);
    this.submit = this.submit.bind(this);
    this.intervalo = this.intervalo.bind(this);
  }

  inputChange(event) {
    this.setState({ symbol: event.target.value });
  }
  intervalo(event) {
    this.setState({ interval: event.target.value });
  }

  optionSelecter(event) {
    this.setState({ function: event.target.value });
  }

  submit(event) {
    this.mensajePost();
    event.preventDefault();
  }

  mensajePost() {
    let url =
      "/stockAlpha?function=" +
      this.state.function +
      "&symbol=" +
      this.state.symbol;
    if (this.state.function == "intraday") {
      url = url + "&interval=" + this.state.interval;
    }
    fetch(url, { method: "GET" })
      .then((data) => data.json())
      .then((data2) => {
        var _visualizer = new visualizer($("#resMSG"));
        _visualizer.visualize(data2);
      });
  }

  render() {
    return (
      <div>
        <form onSubmit={this.submit}>
          <label>Funcion:</label>
          <select
            value={this.state.function}
            className="inputText"
            onChange={this.optionSelecter}
          >
            <option value="intraday">Intraday</option>
            <option value="daily">Daily</option>
            <option value="weekly">Weekly</option>
            <option value="monthly">Monthly</option>
          </select>
          {this.state.function == "intraday" ? (
            <div>
              <label>Intervalo de tiempo:</label>
              <input
                className="inputText"
                required
                type="text"
                placeholder="1min, 5min, 15min  ..."
                value={this.state.interval}
                onChange={this.intervalo}
              ></input>
            </div>
          ) : (
            <div></div>
          )}
          <label>Simbolo:</label>
          <input
            className="inputText"
            required
            type="text"
            placeholder="IBM,AMZN,GOOGL,MSFT ..."
            value={this.state.symbol}
            onChange={this.inputChange}
          ></input>
          <br></br>
          <input className="input" type="submit" value="Submit" />
        </form>
      </div>
    );
  }
}

ReactDOM.render(<Alpha />, document.getElementById("root"));
