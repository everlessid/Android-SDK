var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var fileUpload = require('express-fileupload');

var path = require('path');
var serveStatic = require('serve-static');
var serveIndex = require('serve-index');

app.use(bodyParser.json()); // support json encoded bodies

// reply to request with "Hello World!"
app.get('/', function (req, res) {
  res.send('Hello World!');
});

app.get('/collection/user', function (req, res) {
  	res.send({
		'error': false,
		'data': {
			"a": "b",
			"c": "d"
		}
	});
});

app.get('/collection/user/rio', function (req, res) {
	res.send({
		'error': false,
		'data': {
			"a": "e",
			"c": "f"
		}
	});
});

app.post('/auth/login', function (req, res) {
	console.log(req.body);
	res.send({
		'error': false,
		'data': req.body
	});
});


app.use("/public", serveStatic(path.join(__dirname, 'ups')))
app.use("/public", serveIndex(path.join(__dirname, 'ups')))

// default options
app.use(fileUpload());
app.post('/upload', function(req, res) {
  if (!req.files)
    return res.status(400).send('No files were uploaded.');
 
  // The name of the input field (i.e. "sampleFile") is used to retrieve the uploaded file
  let sampleFile = req.files.file;
 
  // Use the mv() method to place the file somewhere on your server
  sampleFile.mv(__dirname + '/ups/' + sampleFile.name, function(err) {
    if (err)
      return res.status(500).send(err);
 
    res.send({
		'error': false,
		'data': {
			"location": "http://192.168.43.76:8001/public/" + sampleFile.name
		}
	});
  });
});

//start a server on port 80 and log its start to our console
var server = app.listen(8001, function () {

  var port = server.address().port;
  console.log('Example app listening on port ', port);

});