import React from 'react';
import Form from 'react-bootstrap/Form'
import Card from 'react-bootstrap/Card'
import Button from 'react-bootstrap/Button'
import Container from 'react-bootstrap/Container'
import Jumbotron from 'react-bootstrap/Jumbotron'

function App(){

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
            <Card.Title className="text-center">Room Count</Card.Title>
            <Card.Text className="text-left">
              <Form>
                <Form.Group>
                  <Form.Label className="font-weight-bold">Select session:</Form.Label>
                  <Form.Control as="Select">
                    <option>
                      "Sesson Title 1" given by Speaker Name in Room Name
                    </option>
                    <option>
                      "Sesson Title 2" given by Speaker Name in Room Name
                    </option>
                    <option>
                      "Sesson Title 3" given by Speaker Name in Room Name
                    </option>
                  </Form.Control>
                </Form.Group>

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

                <Form.Group>
                  <Form.Label className="font-weight-bold">Select the number of people in the room:</Form.Label>
                  <Form.Control as="Select" id="selectDown">
                    <option>
                      1
                    </option>
                    <option>
                      2
                    </option>
                    <option>3</option>
                  </Form.Control>
                </Form.Group>

                <Form.Group>
                  <Button type="submit" value="Submit" className="btn-lg btn-primary btn-block">Submit</Button>
                </Form.Group>
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