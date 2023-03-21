from flask import Flask, jsonify, request
from flask_cors import CORS
import sys
sys.path.append('/Users/0chord/Desktop/subway_route_map_mini_project/subway_route_map_mini_project/django_subway_route_map/route_map')
from route_map.dijkstra import dijkstra

app = Flask(__name__)
CORS(app)

@app.route('/route_map', methods=['GET'])
## flask에서 get 방식 parameter 요청 방법
def route_map():
    try:
        start = request.args.get('start_station')
        end = request.args.get('end_station')
        result = dijkstra(start, end)
        return jsonify(result)
    except KeyError:
        return jsonify('KeyError')


if __name__ == '__main__':
    app.run(debug=True, port=8080)
