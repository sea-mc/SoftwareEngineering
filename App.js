import React from 'react';
import Form from 'react-bootstrap/Form'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import Container from 'react-bootstrap/Container'
import Jumbotron from 'react-bootstrap/Jumbotron'

function handleSubmit(event) {
  alert("Entry submitted.");
}

function PopulateSessionDropdown() {
  var sessions = ["1", "2", "3", "4", "5"];
  var options = [];

  for (var i = 0; i < sessions.length; i++) {
    options.push(<option>Session {sessions[i]} given by *Speaker Name* in *Room Name*</option>);
  }

  return (
    <div>
      <Form.Group>
        <Form.Label className="font-weight-bold">Select session:</Form.Label>
        <Form.Control as="Select">
          {options}
        </Form.Control>
      </Form.Group>
    </div>
  );
}

function PopulateCountDropdown() {

  var options = [];

  for (var x = 0; x <= 50; x++) {
    options.push(<option>{x}</option>);
  }

  return (
    <div>
      <Form.Group>
        <Form.Label className="font-weight-bold">Select the number of people in the room:</Form.Label>
        <Form.Control as="Select" id="dropdown">
          {options}
        </Form.Control>
      </Form.Group>
    </div>
  );
}

function PopulateTimeDropdown() {
  return (
    <div>
      <Form.Group>
        <Form.Label className="font-weight-bold">Select the time of the count:</Form.Label>
        <Form.Control as="Select">
          <option>
            Beginning
          </option>
          <option>
            Middle
          </option>
          <option>
            End
          </option>
        </Form.Control>
      </Form.Group>
    </div>
  );
}

function CreateSubmitButton() {
  return (
    <div>
      <Form.Group>
        <Button type="submit" value="Submit" className="btn-lg btn-primary btn-block">Submit</Button>
      </Form.Group>
    </div>
  );
}

function App() {
  return(
    <div>
    <Jumbotron>
      <Container>
        <h1><span className="font-weight-bold">Boston</span> Code Camp</h1>
      </Container>
    </Jumbotron>

    <Container>
        <center>
        <Card bg="light" style={{ width: '40rem'}} border="dark" className="mt-5">
          <Card.Body>
            <Card.Title>Room Count</Card.Title>
            <Card.Text className="text-left">
              <Form onSubmit={handleSubmit}>
                
                <PopulateSessionDropdown />
                <PopulateTimeDropdown />
                <PopulateCountDropdown />

                <CreateSubmitButton />

              </Form>
            </Card.Text>
          </Card.Body>
        </Card>
        </center>
    </Container>
    </div>
  );
}

export default App;
