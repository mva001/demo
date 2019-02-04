package com.example.demo;


class Animal {
}

class Cat extends Animal {
	void meow() {
	}
}

interface Lovable {
	void loveMe1();
	}



	public class RunMe {
		public static class Foo {
			public int i = 0;
		}

		public class Cucu {

		}

		public interface HandleEvent {
			void handle(int ev);
		}

		static void doDo(Foo f) {
			f.i = 3;
		}

		static void eventHandler(HandleEvent h) {
			h.handle(10);
		}

		public static void main(String[] args) {
			Foo foo = new Foo();
			System.out.println(foo.i);
			doDo(foo);
			System.out.println(foo.i);


			eventHandler(new HandleEvent() {

				@Override
				public void handle(int ev) {
					System.out.println("Event:" + ev);
				}
			});

		}
	}

	class Consumer {
		RunMe.Foo foo = new RunMe.Foo();
	}
