#include <math.h>
#include <string.h>
#define SQR(x) x*x

class NamedPoint {
private:  float x;
          float y;
          char* name;

public: float getX(){
		return x;
	}

	float getY(){
		return y;
	}

	const char* getName(){
		return name;
	}

	void setX(float x){
		this->x = x;
	}

	void setY(float y){
		this->y = y;
	}
	
    float getEuclideanDistance(const NamedPoint& first, const NamedPoint& second){
        return sqrt(SQR(first.x-second.x) + SQR(first.y-second.y));
    }

    float getEuclideanDistanceFromStartingPoint(){
        return sqrt(SQR(x) + SQR(y));
    }

    void setName(char* name){
		delete this->name;
		if (name == NULL){
			this->name = NULL;
		}
		else{
			this->name = new char[strlen(name) + 1];
			strcpy (this->name, name);
		}
	}
    NamedPoint(){}
    NamedPoint(float x, float y, char* name){
		if (name == NULL){
			this->name = NULL;
		}
		else{
			this->name = new char[strlen(name) + 1];
			strcpy (this->name, name);
		}
	}

    NamedPoint(const NamedPoint& other){
        x = other.x;
        y = other.y;
		if (other.name == NULL){
			name = NULL;
		}
		else{
			name = new char[strlen(other.name) + 1];
			strcpy (name, other.name);
		}
	}
	
    ~NamedPoint(){
		delete[] this->name;             
	}
	
    NamedPoint& operator=(const NamedPoint& other){
		if (this == &other) {
			return *this;
		}
		x = other.x;
		y = other.y;

		delete name;
		if (other.name == NULL){
			name = NULL;
		}
		else{
			name = new char[strlen(other.name) + 1];
			strcpy (name, other.name);
		}
		return *this;
	}
	
    NamedPoint operator+(const NamedPoint& other){
        NamedPoint namedPoint;
        namedPoint.x = this->x + other.x;
        namedPoint.y = this->y + other.y;
		return namedPoint;
	}
	
    NamedPoint operator-(const NamedPoint& other){
        NamedPoint namedPoint;
        namedPoint.x = this->x - other.x;
        namedPoint.y = this->y - other.y;
		return namedPoint;
	}
	
    bool operator>=(NamedPoint& other){
        bool isGreaterOrEqual = true;
        if (getEuclideanDistanceFromStartingPoint() < other.getEuclideanDistanceFromStartingPoint()){
            isGreaterOrEqual = false;
        }
		return isGreaterOrEqual;
	}
	
    bool operator<=(NamedPoint& other){
        bool isSmallerOrEqual = true;
        if (getEuclideanDistanceFromStartingPoint() > other.getEuclideanDistanceFromStartingPoint()){
            isSmallerOrEqual = false;
        }
		return isSmallerOrEqual;
	}
	
    bool operator>(NamedPoint& other){
        bool isGreater = false;
        if (getEuclideanDistanceFromStartingPoint() > other.getEuclideanDistanceFromStartingPoint()){
            isGreater = true;
        }
		return isGreater;
	}
	
    bool operator<(NamedPoint& other){
        bool isSmaller = false;
        if (getEuclideanDistanceFromStartingPoint() < other.getEuclideanDistanceFromStartingPoint()){
            isSmaller = true;
        }
		return isSmaller;
	}
	
    bool operator==(const NamedPoint& other){
        bool isEqual = false;
        if (this->x == other.x && this->y == other.y){
            isEqual = true;
        }
		return isEqual;
	}
	
    bool operator!=(const NamedPoint& other){
        bool isNotEqual = true;
        if (this->x == other.x && this->y == other.y){
            isNotEqual = false;
        }
		return isNotEqual;
	}
};

int main() {
	return 0;
}
